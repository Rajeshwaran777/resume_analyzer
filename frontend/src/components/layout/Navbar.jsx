import { Link, useLocation } from "react-router-dom";

export default function Navbar() {
  const location = useLocation();

  const navLinkClass = (path) =>
    `px-4 py-2 rounded-full text-sm font-medium transition ${
      location.pathname === path
        ? "bg-white text-slate-900 shadow"
        : "text-slate-200 hover:text-white hover:bg-slate-800/70"
    }`;

  return (
    <nav className="sticky top-0 z-50 border-b border-slate-800/50 bg-slate-950/95 backdrop-blur">
      <div className="max-w-7xl mx-auto px-6 py-4 flex items-center justify-between">
        <Link to="/" className="text-white text-2xl font-bold tracking-tight">
          Resume Analyzer
        </Link>

        <div className="flex items-center gap-2">
          <Link to="/" className={navLinkClass("/")}>
            Home
          </Link>
          <Link to="/analyzer" className={navLinkClass("/analyzer")}>
            Analyzer
          </Link>
          <Link to="/history" className={navLinkClass("/history")}>
            History
          </Link>
        </div>
      </div>
    </nav>
  );
}