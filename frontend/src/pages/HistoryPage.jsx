import HistoryList from "../components/analyzer/HistoryList";

export default function HistoryPage() {
  return (
    <div className="max-w-6xl mx-auto px-6 py-14">
      <div className="mb-10">
        <span className="inline-flex rounded-full bg-slate-900 text-white px-4 py-1 text-sm font-medium mb-4">
          Persisted Analysis Records
        </span>
        <h2 className="text-5xl font-extrabold tracking-tight mb-4">
          Search and review past resume evaluations.
        </h2>
        <p className="text-lg text-slate-600 max-w-3xl leading-8">
          Browse saved analysis results, search by file name, and filter by score
          to quickly inspect stronger candidate matches.
        </p>
      </div>

      <HistoryList />
    </div>
  );
}