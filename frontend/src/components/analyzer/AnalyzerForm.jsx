import { useState } from "react";
import { analyzeText, analyzeFile } from "../../api/resumeApi";
import ResultCard from "./ResultCard";

export default function AnalyzerForm() {
  const [resumeText, setResumeText] = useState("");
  const [jobDescription, setJobDescription] = useState("");
  const [file, setFile] = useState(null);
  const [mode, setMode] = useState("text");
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");
    setResult(null);

    try {
      let data;

      if (mode === "text") {
        data = await analyzeText({ resumeText, jobDescription });
      } else {
        if (!file) {
          throw new Error("Please upload a PDF or TXT file.");
        }
        data = await analyzeFile(file, jobDescription);
      }

      setResult(data);

      setTimeout(() => {
        window.scrollTo({ top: document.body.scrollHeight, behavior: "smooth" });
      }, 120);
    } catch (err) {
      console.log("FULL ERROR:", err);
      console.log("RESPONSE:", err?.response);
      console.log("REQUEST:", err?.request);
      console.log("MESSAGE:", err?.message);

      setError(
        err?.response?.data?.message ||
          err?.message ||
          "Something went wrong"
      );
    } finally {
      setLoading(false);
    }
  };

  const modeButtonClass = (current) =>
    `px-5 py-2.5 rounded-xl font-semibold transition ${
      mode === current
        ? "bg-sky-600 text-white shadow"
        : "bg-slate-100 text-slate-700 hover:bg-slate-200"
    }`;

  return (
    <div className="bg-white rounded-[28px] shadow-xl border border-slate-200 p-6 md:p-8">
      <div className="flex flex-wrap gap-3 mb-8">
        <button
          type="button"
          onClick={() => setMode("text")}
          className={modeButtonClass("text")}
        >
          Text Input
        </button>
        <button
          type="button"
          onClick={() => setMode("file")}
          className={modeButtonClass("file")}
        >
          File Upload
        </button>
      </div>

      <form onSubmit={handleSubmit} className="space-y-6">
        {mode === "text" ? (
          <div>
            <label className="block text-sm font-semibold text-slate-700 mb-3">
              Resume Text
            </label>
            <textarea
              value={resumeText}
              onChange={(e) => setResumeText(e.target.value)}
              rows="10"
              className="w-full border border-slate-300 rounded-2xl p-4 outline-none focus:ring-4 focus:ring-sky-100 focus:border-sky-500"
              placeholder="Paste resume text here..."
            />
          </div>
        ) : (
          <div>
            <label className="block text-sm font-semibold text-slate-700 mb-3">
              Upload Resume (PDF/TXT)
            </label>
            <input
              type="file"
              accept=".pdf,.txt"
              onChange={(e) => setFile(e.target.files[0])}
              className="w-full border-2 border-dashed border-slate-300 rounded-2xl p-5 cursor-pointer hover:border-sky-500 focus:outline-none"
            />
            {file && (
              <p className="mt-3 text-sm text-slate-500">
                Selected file: <span className="font-medium text-slate-800">{file.name}</span>
              </p>
            )}
          </div>
        )}

        <div>
          <label className="block text-sm font-semibold text-slate-700 mb-3">
            Job Description
          </label>
          <textarea
            value={jobDescription}
            onChange={(e) => setJobDescription(e.target.value)}
            rows="8"
            className="w-full border border-slate-300 rounded-2xl p-4 outline-none focus:ring-4 focus:ring-sky-100 focus:border-sky-500"
            placeholder="Paste job description here..."
          />
        </div>

        <button
          type="submit"
          disabled={loading}
          className="inline-flex items-center justify-center bg-slate-950 text-white px-7 py-3.5 rounded-2xl font-semibold shadow hover:bg-slate-800 disabled:opacity-60 disabled:cursor-not-allowed transition"
        >
          {loading ? (
            <span className="flex items-center gap-2">
              <span className="w-4 h-4 border-2 border-white border-t-transparent rounded-full animate-spin"></span>
              Analyzing...
            </span>
          ) : (
            "Analyze Resume"
          )}
        </button>
      </form>

      {error && (
        <div className="mt-8 rounded-2xl border border-red-200 bg-red-50 text-red-700 px-5 py-4">
          <p className="font-semibold mb-1">Request failed</p>
          <p>{error}</p>
        </div>
      )}

      {!result && !loading && (
        <div className="mt-10 rounded-2xl bg-slate-50 border border-slate-200 p-6 text-slate-500">
          Your analysis result will appear here after submission.
        </div>
      )}

      {result && <ResultCard result={result} />}
    </div>
  );
}