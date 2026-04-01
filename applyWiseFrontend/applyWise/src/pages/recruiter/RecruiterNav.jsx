import React from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";

const RecruiterNav = () => {
  const token = localStorage.getItem("token");
  const location = useLocation();

  const navigate = useNavigate();

  const hideAuthButtons =
    location.pathname === "/login" || location.pathname === "/register";

  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  };

  return (
    <nav className="bg-white shadow-md">
      <div className="max-w-7xl mx-auto px-6 py-4 flex justify-between items-center">
        <Link to="/" className="text-2xl font-bold text-blue-600">
          ApplyWise
        </Link>

        {!hideAuthButtons ? (
          <div className="flex items-center space-x-6">
            <Link to="/recruiter/dashboard" className="text-gray-700 hover:text-blue-600">
              Home
            </Link>

            <Link to="/recruiter/dashboard/added-jobs" className="text-gray-700 hover:text-blue-600">
              Added Jobs
            </Link>

            <Link to="/recruiter/dashboard/add-job" className="text-gray-700 hover:text-blue-600">
              Add Job
            </Link>

            <Link to="/recruiter/dashboard/applications" className="text-gray-700 hover:text-blue-600">
              Applications
            </Link>

            {!token ? (
              <>
                <Link
                  to="/login"
                  className="bg-blue-600 text-white px-4 py-2 rounded-lg"
                >
                  Login
                </Link>

                <Link
                  to="/register"
                  className="border border-blue-600 text-blue-600 px-4 py-2 rounded-lg"
                >
                  Register
                </Link>
              </>
            ) : (
              <button
                onClick={handleLogout}
                className="bg-red-500 text-white px-4 py-2 rounded-lg"
              >
                Logout
              </button>
            )}
          </div>
        ) : (
          <div className="flex items-center space-x-6">
            <Link to="/" className="text-gray-700 hover:text-blue-600">
              Home
            </Link>

            {location.pathname === "/login" ? (
              <Link
                to="/register"
                className="text-gray-700 hover:text-blue-600"
              >
                Register
              </Link>
            ) : (
              <Link to="/login" className="text-gray-700 hover:text-blue-600">
                Login
              </Link>
            )}
          </div>
        )}
      </div>
    </nav>
  );
};

export default RecruiterNav;
