import { Link } from "react-router-dom";

function Footer() {
  return (
    <footer className="bg-gray-900 text-gray-300">

      <div className="max-w-7xl mx-auto px-6 py-10 grid grid-cols-1 md:grid-cols-4 gap-8">

        {/* Logo + About */}
        <div>
          <h2 className="text-2xl font-bold text-white mb-4">
            ApplyWise
          </h2>
          <p className="text-sm">
            Find your dream job, connect with recruiters, and grow your career with ease.
          </p>
        </div>

        {/* Quick Links */}
        <div>
          <h3 className="text-white font-semibold mb-4">Quick Links</h3>
          <ul className="space-y-2 text-sm">
            <li><Link to="/" className="hover:text-white">Home</Link></li>
            <li><Link to="/jobs" className="hover:text-white">Jobs</Link></li>
            <li><Link to="/login" className="hover:text-white">Login</Link></li>
            <li><Link to="/register" className="hover:text-white">Register</Link></li>
          </ul>
        </div>

        {/* Roles */}
        <div>
          <h3 className="text-white font-semibold mb-4">For Users</h3>
          <ul className="space-y-2 text-sm">
            <li>Job Seekers</li>
            <li>Recruiters</li>
            <li>Admins</li>
          </ul>
        </div>

        {/* Contact */}
        <div>
          <h3 className="text-white font-semibold mb-4">Contact</h3>
          <p className="text-sm">Email: support@applywise.com</p>
          <p className="text-sm">Phone: +91 98765 43210</p>
        </div>

      </div>

      {/* Bottom Line */}
      <div className="border-t border-gray-700 text-center py-4 text-sm">
        © {new Date().getFullYear()} ApplyWise. All rights reserved.
      </div>

    </footer>
  );
}

export default Footer;