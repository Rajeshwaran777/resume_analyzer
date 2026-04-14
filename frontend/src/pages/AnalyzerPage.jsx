import AnalyzerForm from "../components/analyzer/AnalyzerForm";

export default function AnalyzerPage() {
  return (
    <div className="max-w-6xl mx-auto px-6 py-14">
      <div className="mb-10">
        <span className="inline-flex rounded-full bg-slate-900 text-white px-4 py-1 text-sm font-medium mb-4">
          AI-Assisted Resume Matching
        </span>
        <h2 className="text-5xl font-extrabold tracking-tight mb-4">
          Analyze resumes with hybrid scoring.
        </h2>
        <p className="text-lg text-slate-600 max-w-3xl leading-8">
          Upload a resume or paste text, compare it against a job description,
          and get keyword score, semantic score, final score, strengths, gaps,
          and an AI summary.
        </p>
      </div>

      <AnalyzerForm />
    </div>
  );
}