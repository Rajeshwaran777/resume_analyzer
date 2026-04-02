import AnalyzerForm from "../components/analyzer/AnalyzerForm";

export default function AnalyzerPage() {
  return (
    <div className="max-w-6xl mx-auto px-6 py-14">
      <div className="mb-10">
        <span className="inline-flex rounded-full bg-slate-900 text-white px-4 py-1 text-sm font-medium mb-4">
          Resume Matching Workspace
        </span>
        <h2 className="text-5xl font-extrabold tracking-tight mb-4">
          Analyze resumes with a cleaner workflow.
        </h2>
        <p className="text-lg text-slate-600 max-w-3xl leading-8">
          Paste resume text or upload a file, compare it against a job description,
          and get a structured result with matched and missing keywords.
        </p>
      </div>

      <AnalyzerForm />
    </div>
  );
}