import { useEffect, useState } from "react";
import { filterHistory, getHistory, searchHistory } from "../../api/resumeApi";

export default function HistoryList() {
  const [records, setRecords] = useState([]);
  const [fileName, setFileName] = useState("");
  const [minScore, setMinScore] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const loadHistory = async () => {
    setLoading(true);
    setError("");
    try {
      const data = await getHistory(0, 10);
      setRecords(data.content || []);
    } catch (err) {
      setError(err?.response?.data?.message || "Failed to load history");
    } finally {
      setLoading(false);
    }
  };

  const handleSearch = async () => {
    setLoading(true);
    setError("");
    try {
      const data = await searchHistory(fileName);
      setRecords(data);
    } catch (err) {
      setError(err?.response?.data?.message || "Search failed");
    } finally {
      setLoading(false);
    }
  };

  const handleFilter = async () => {
    setLoading(true);
    setError("");
    try {
      const data = await filterHistory(minScore);
      setRecords(data);
    } catch (err) {
      setError(err?.response?.data?.message || "Filter failed");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadHistory();
  }, []);

  return (
    <div className="bg-white rounded-[28px] shadow-xl border border-slate-200 p-6 md:p-8">
      <div className="grid lg:grid-cols-3 gap-4 mb-6">
        <input
          type="text"
          value={fileName}
          onChange={(e) => setFileName(e.target.value)}
          placeholder="Search by file name"
          className="border border-slate-300 rounded-2xl p-3.5 outline-none focus:ring-4 focus:ring-sky-100 focus:border-sky-500"
        />

        <button
          onClick={handleSearch}
          className="bg-sky-600 text-white rounded-2xl px-4 py-3.5 font-semibold hover:bg-sky-700 transition"
        >
          Search
        </button>

        <div className="flex gap-2">
          <input
            type="number"
            value={minScore}
            onChange={(e) => setMinScore(e.target.value)}
            placeholder="Min final score"
            className="border border-slate-300 rounded-2xl p-3.5 w-full outline-none focus:ring-4 focus:ring-sky-100 focus:border-sky-500"
          />
          <button
            onClick={handleFilter}
            className="bg-slate-950 text-white rounded-2xl px-4 py-3.5 font-semibold hover:bg-slate-800 transition"
          >
            Filter
          </button>
        </div>
      </div>

      <button
        onClick={loadHistory}
        className="mb-8 border border-slate-300 bg-white rounded-2xl px-5 py-2.5 font-medium hover:bg-slate-50 transition"
      >
        Reset
      </button>

      {loading && (
        <div className="rounded-2xl bg-slate-50 border border-slate-200 p-5 text-slate-600">
          Loading history...
        </div>
      )}

      {error && (
        <div className="rounded-2xl border border-red-200 bg-red-50 text-red-700 px-5 py-4 mb-6">
          {error}
        </div>
      )}

      {!loading && !records.length && (
        <div className="rounded-2xl bg-slate-50 border border-slate-200 p-6 text-slate-500">
          No history records found.
        </div>
      )}

      <div className="space-y-5">
        {records.map((item) => (
          <div
            key={item.id}
            className="border border-slate-200 bg-slate-50 rounded-3xl p-5 shadow-sm"
          >
            <div className="flex justify-between items-start gap-4 flex-wrap mb-4">
              <div>
                <h3 className="text-lg font-bold">
                  {item.resumeFileName || "Text Analysis"}
                </h3>
                <p className="text-sm text-slate-500 mt-1">{item.createdAt}</p>
              </div>

              <div className="text-right">
                <p className="text-3xl font-extrabold text-emerald-700">
                  {item.finalScore}%
                </p>
                <p className="text-sm font-medium text-slate-600">
                  Final Score
                </p>
              </div>
            </div>

            <div className="grid md:grid-cols-3 gap-4 mb-4">
              <div className="rounded-2xl bg-white border border-slate-200 p-4">
                <p className="text-xs text-slate-500 mb-1">Keyword Score</p>
                <p className="text-2xl font-bold">{item.keywordScore}%</p>
              </div>

              <div className="rounded-2xl bg-white border border-slate-200 p-4">
                <p className="text-xs text-slate-500 mb-1">Semantic Score</p>
                <p className="text-2xl font-bold text-sky-700">
                  {item.semanticScore}%
                </p>
              </div>

              <div className="rounded-2xl bg-white border border-slate-200 p-4">
                <p className="text-xs text-slate-500 mb-1">Assessment</p>
                <p className="text-xl font-bold text-emerald-700">
                  {item.message}
                </p>
              </div>
            </div>

            <div className="mb-4 rounded-2xl bg-white border border-slate-200 p-4">
              <p className="text-sm font-semibold text-slate-700 mb-2">
                AI Summary
              </p>
              <p className="text-sm text-slate-600 leading-6">{item.summary}</p>
            </div>

            <div className="grid md:grid-cols-2 gap-4 mb-4">
              <div className="rounded-2xl bg-white border border-slate-200 p-4">
                <p className="text-sm font-semibold text-slate-700 mb-3">
                  Strengths
                </p>
                {item.strengths?.length ? (
                  <ul className="space-y-2">
                    {item.strengths.map((strength, index) => (
                      <li key={index} className="text-sm text-slate-600">
                        • {strength}
                      </li>
                    ))}
                  </ul>
                ) : (
                  <p className="text-sm text-slate-500">No strengths available.</p>
                )}
              </div>

              <div className="rounded-2xl bg-white border border-slate-200 p-4">
                <p className="text-sm font-semibold text-slate-700 mb-3">
                  Gaps
                </p>
                {item.gaps?.length ? (
                  <ul className="space-y-2">
                    {item.gaps.map((gap, index) => (
                      <li key={index} className="text-sm text-slate-600">
                        • {gap}
                      </li>
                    ))}
                  </ul>
                ) : (
                  <p className="text-sm text-slate-500">No gaps available.</p>
                )}
              </div>
            </div>

            <div className="mb-4">
              <p className="text-sm font-semibold text-slate-700 mb-3">
                Matched Keywords
              </p>
              <div className="flex flex-wrap gap-2">
                {item.matchedKeywords?.map((keyword) => (
                  <span
                    key={keyword}
                    className="bg-emerald-100 text-emerald-800 px-3 py-1 rounded-full text-sm font-medium"
                  >
                    {keyword}
                  </span>
                ))}
              </div>
            </div>

            <div className="mb-4">
              <p className="text-sm font-semibold text-slate-700 mb-3">
                Missing Keywords
              </p>
              <div className="flex flex-wrap gap-2">
                {item.missingKeywords?.map((keyword) => (
                  <span
                    key={keyword}
                    className="bg-rose-100 text-rose-700 px-3 py-1 rounded-full text-sm font-medium"
                  >
                    {keyword}
                  </span>
                ))}
              </div>
            </div>

            <div className="grid md:grid-cols-2 gap-4">
              <div className="rounded-2xl bg-white border border-slate-200 p-4">
                <p className="text-sm font-semibold text-slate-700 mb-3">
                  Normalized Resume Skills
                </p>
                <div className="flex flex-wrap gap-2">
                  {item.normalizedResumeSkills?.map((skill) => (
                    <span
                      key={skill}
                      className="bg-slate-100 text-slate-700 px-3 py-1 rounded-full text-sm"
                    >
                      {skill}
                    </span>
                  ))}
                </div>
              </div>

              <div className="rounded-2xl bg-white border border-slate-200 p-4">
                <p className="text-sm font-semibold text-slate-700 mb-3">
                  Normalized Job Skills
                </p>
                <div className="flex flex-wrap gap-2">
                  {item.normalizedJobSkills?.map((skill) => (
                    <span
                      key={skill}
                      className="bg-slate-100 text-slate-700 px-3 py-1 rounded-full text-sm"
                    >
                      {skill}
                    </span>
                  ))}
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}