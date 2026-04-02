export default function ResultCard({ result }) {
  return (
    <div className="mt-10 border-t border-slate-200 pt-8">
      <div className="flex items-center justify-between flex-wrap gap-4 mb-6">
        <div>
          <p className="text-sm font-semibold text-slate-500 uppercase tracking-wide">
            Analysis Result
          </p>
          <h3 className="text-3xl font-extrabold tracking-tight mt-1">
            Resume Match Summary
          </h3>
        </div>

        <div className="rounded-full bg-emerald-100 text-emerald-700 px-4 py-2 font-semibold">
          {result.message}
        </div>
      </div>

      <div className="grid md:grid-cols-2 gap-5 mb-8">
        <div className="bg-sky-50 border border-sky-100 rounded-3xl p-6 shadow-sm">
          <p className="text-sm text-slate-500 mb-2">Match Percentage</p>
          <p className="text-5xl font-extrabold text-sky-700">
            {result.matchPercentage}%
          </p>
        </div>

        <div className="bg-emerald-50 border border-emerald-100 rounded-3xl p-6 shadow-sm">
          <p className="text-sm text-slate-500 mb-2">Assessment</p>
          <p className="text-3xl font-bold text-emerald-700">
            {result.message}
          </p>
        </div>
      </div>

      <div className="grid md:grid-cols-2 gap-8 mb-8">
        <div>
          <h4 className="font-bold text-lg mb-4">Matched Keywords</h4>
          <div className="flex flex-wrap gap-2">
            {result.matchedKeywords?.length ? (
              result.matchedKeywords.map((item) => (
                <span
                  key={item}
                  className="bg-emerald-100 text-emerald-800 px-3 py-1.5 rounded-full text-sm font-medium"
                >
                  {item}
                </span>
              ))
            ) : (
              <p className="text-slate-500">No matched keywords found.</p>
            )}
          </div>
        </div>

        <div>
          <h4 className="font-bold text-lg mb-4">Missing Keywords</h4>
          <div className="flex flex-wrap gap-2">
            {result.missingKeywords?.length ? (
              result.missingKeywords.map((item) => (
                <span
                  key={item}
                  className="bg-rose-100 text-rose-700 px-3 py-1.5 rounded-full text-sm font-medium"
                >
                  {item}
                </span>
              ))
            ) : (
              <p className="text-slate-500">No missing keywords.</p>
            )}
          </div>
        </div>
      </div>

      <div className="grid md:grid-cols-2 gap-8">
        <div className="bg-slate-50 rounded-2xl border border-slate-200 p-5">
          <h4 className="font-bold mb-4">Extracted Resume Keywords</h4>
          <div className="flex flex-wrap gap-2">
            {result.extractedResumeKeywords?.map((item) => (
              <span
                key={item}
                className="bg-white border border-slate-200 text-slate-700 px-3 py-1 rounded-full text-sm"
              >
                {item}
              </span>
            ))}
          </div>
        </div>

        <div className="bg-slate-50 rounded-2xl border border-slate-200 p-5">
          <h4 className="font-bold mb-4">Extracted Job Keywords</h4>
          <div className="flex flex-wrap gap-2">
            {result.extractedJobKeywords?.map((item) => (
              <span
                key={item}
                className="bg-white border border-slate-200 text-slate-700 px-3 py-1 rounded-full text-sm"
              >
                {item}
              </span>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}