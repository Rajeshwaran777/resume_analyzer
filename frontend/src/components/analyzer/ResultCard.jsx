export default function ResultCard({ result }) {
  const {
    keywordScore,
    semanticScore,
    finalScore,
    matchedKeywords,
    missingKeywords,
    strengths,
    gaps,
    summary,
    normalizedResumeSkills,
    normalizedJobSkills,
    message,
  } = result;

  return (
    <div className="mt-10 border-t border-slate-200 pt-8">
      <div className="flex items-center justify-between flex-wrap gap-4 mb-6">
        <div>
          <p className="text-sm font-semibold text-slate-500 uppercase tracking-wide">
            AI-Assisted Analysis Result
          </p>
          <h3 className="text-3xl font-extrabold tracking-tight mt-1">
            Resume Match Summary
          </h3>
        </div>

        <div className="rounded-full bg-emerald-100 text-emerald-700 px-4 py-2 font-semibold">
          {message}
        </div>
      </div>

      <div className="grid md:grid-cols-3 gap-5 mb-8">
        <div className="bg-slate-50 border border-slate-200 rounded-3xl p-6 shadow-sm">
          <p className="text-sm text-slate-500 mb-2">Keyword Score</p>
          <p className="text-4xl font-extrabold text-slate-900">
            {keywordScore}%
          </p>
        </div>

        <div className="bg-sky-50 border border-sky-100 rounded-3xl p-6 shadow-sm">
          <p className="text-sm text-slate-500 mb-2">Semantic Score</p>
          <p className="text-4xl font-extrabold text-sky-700">
            {semanticScore}%
          </p>
        </div>

        <div className="bg-emerald-50 border border-emerald-100 rounded-3xl p-6 shadow-sm">
          <p className="text-sm text-slate-500 mb-2">Final Score</p>
          <p className="text-5xl font-extrabold text-emerald-700">
            {finalScore}%
          </p>
        </div>
      </div>

      <div className="mb-8 rounded-2xl bg-amber-50 border border-amber-100 p-5">
        <p className="text-sm font-semibold text-slate-700 mb-2">AI Summary</p>
        <p className="text-slate-700 leading-7">{summary}</p>
      </div>

      <div className="grid md:grid-cols-2 gap-8 mb-8">
        <div>
          <h4 className="font-bold text-lg mb-4">Matched Keywords</h4>
          <div className="flex flex-wrap gap-2">
            {matchedKeywords?.length ? (
              matchedKeywords.map((item) => (
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
            {missingKeywords?.length ? (
              missingKeywords.map((item) => (
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

      <div className="grid md:grid-cols-2 gap-8 mb-8">
        <div className="bg-slate-50 rounded-2xl border border-slate-200 p-5">
          <h4 className="font-bold mb-4">Strengths</h4>
          {strengths?.length ? (
            <ul className="space-y-3">
              {strengths.map((item, index) => (
                <li key={index} className="text-slate-700 leading-6">
                  • {item}
                </li>
              ))}
            </ul>
          ) : (
            <p className="text-slate-500">No strengths available.</p>
          )}
        </div>

        <div className="bg-slate-50 rounded-2xl border border-slate-200 p-5">
          <h4 className="font-bold mb-4">Gaps</h4>
          {gaps?.length ? (
            <ul className="space-y-3">
              {gaps.map((item, index) => (
                <li key={index} className="text-slate-700 leading-6">
                  • {item}
                </li>
              ))}
            </ul>
          ) : (
            <p className="text-slate-500">No gaps available.</p>
          )}
        </div>
      </div>

      <div className="grid md:grid-cols-2 gap-8">
        <div className="bg-slate-50 rounded-2xl border border-slate-200 p-5">
          <h4 className="font-bold mb-4">Normalized Resume Skills</h4>
          <div className="flex flex-wrap gap-2">
            {normalizedResumeSkills?.length ? (
              normalizedResumeSkills.map((item) => (
                <span
                  key={item}
                  className="bg-white border border-slate-200 text-slate-700 px-3 py-1 rounded-full text-sm"
                >
                  {item}
                </span>
              ))
            ) : (
              <p className="text-slate-500">No normalized resume skills.</p>
            )}
          </div>
        </div>

        <div className="bg-slate-50 rounded-2xl border border-slate-200 p-5">
          <h4 className="font-bold mb-4">Normalized Job Skills</h4>
          <div className="flex flex-wrap gap-2">
            {normalizedJobSkills?.length ? (
              normalizedJobSkills.map((item) => (
                <span
                  key={item}
                  className="bg-white border border-slate-200 text-slate-700 px-3 py-1 rounded-full text-sm"
                >
                  {item}
                </span>
              ))
            ) : (
              <p className="text-slate-500">No normalized job skills.</p>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}