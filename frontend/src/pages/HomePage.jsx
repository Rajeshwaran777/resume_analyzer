import { Link } from "react-router-dom";

export default function HomePage() {
  return (
    <div className="max-w-7xl mx-auto px-6 py-20">
      <section className="grid lg:grid-cols-2 gap-12 items-center">
        <div>
          <span className="inline-flex items-center rounded-full bg-sky-100 text-sky-800 px-4 py-1 text-sm font-semibold mb-6">
            Spring Boot + React + PostgreSQL
          </span>

          <h1 className="text-5xl lg:text-6xl font-extrabold leading-tight tracking-tight mb-6">
            Analyze resumes like a real product, not a classroom demo.
          </h1>

          <p className="text-lg text-slate-600 leading-8 mb-8 max-w-2xl">
            Upload a resume or paste resume text, compare it against a job description,
            get a match score instantly, and explore saved analysis history with search and filters.
          </p>

          <div className="flex flex-wrap gap-4">
            <Link
              to="/analyzer"
              className="bg-slate-950 text-white px-6 py-3 rounded-xl font-semibold shadow hover:bg-slate-800 transition"
            >
              Start Analyzing
            </Link>

            <Link
              to="/history"
              className="border border-slate-300 bg-white px-6 py-3 rounded-xl font-semibold hover:bg-slate-50 transition"
            >
              Explore History
            </Link>
          </div>

          <div className="grid grid-cols-3 gap-4 mt-12 max-w-xl">
            <div className="bg-white rounded-2xl p-4 shadow-sm border border-slate-200">
              <p className="text-2xl font-bold">Text</p>
              <p className="text-sm text-slate-500">Resume analysis</p>
            </div>
            <div className="bg-white rounded-2xl p-4 shadow-sm border border-slate-200">
              <p className="text-2xl font-bold">PDF/TXT</p>
              <p className="text-sm text-slate-500">File upload support</p>
            </div>
            <div className="bg-white rounded-2xl p-4 shadow-sm border border-slate-200">
              <p className="text-2xl font-bold">History</p>
              <p className="text-sm text-slate-500">Saved results</p>
            </div>
          </div>
        </div>

        <div className="bg-white rounded-[28px] shadow-2xl border border-slate-200 p-8">
          <div className="flex items-center justify-between mb-6">
            <div>
              <p className="text-sm text-slate-500">Latest Match</p>
              <h3 className="text-3xl font-bold mt-1">85.71%</h3>
            </div>
            <div className="bg-emerald-100 text-emerald-700 px-4 py-2 rounded-full font-semibold text-sm">
              Strong Match
            </div>
          </div>

          <div className="grid grid-cols-2 gap-4 mb-6">
            <div className="rounded-2xl bg-sky-50 p-5">
              <p className="text-sm text-slate-500">Matched Skills</p>
              <p className="text-xl font-bold mt-1">6</p>
            </div>
            <div className="rounded-2xl bg-rose-50 p-5">
              <p className="text-sm text-slate-500">Missing Skills</p>
              <p className="text-xl font-bold mt-1">1</p>
            </div>
          </div>

          <div className="mb-5">
            <p className="text-sm font-semibold text-slate-700 mb-3">Matched Keywords</p>
            <div className="flex flex-wrap gap-2">
              {["java", "springboot", "mysql", "git", "docker", "restapi"].map((item) => (
                <span
                  key={item}
                  className="bg-emerald-100 text-emerald-800 px-3 py-1 rounded-full text-sm font-medium"
                >
                  {item}
                </span>
              ))}
            </div>
          </div>

          <div>
            <p className="text-sm font-semibold text-slate-700 mb-3">Missing Keyword</p>
            <span className="bg-rose-100 text-rose-700 px-3 py-1 rounded-full text-sm font-medium">
              aws
            </span>
          </div>
        </div>
      </section>
    </div>
  );
}