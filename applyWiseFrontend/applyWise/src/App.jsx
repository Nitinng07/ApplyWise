import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";

import Home from "./pages/Home";
import Jobs from "./pages/Jobs";
import Navbar from "./components/Navbar";
import Login from "./pages/auth/Login";
import Register from "./pages/auth/Register";
import ProtectedRoute from "./routes/ProtectedRoute";
import UserDashboard from "./pages/user/UserDashBoard";
import RecruiterDashboard from "./pages/recruiter/RecruiterDashboard";
import AdminDashboard from "./pages/admin/AdminDashBoard";
import AppliedJobs from "./pages/AppliedJobs";
import AddJob from "./pages/recruiter/AddJob";
import Application from "./pages/recruiter/Application";
import RecruiterAddedJobs from "./pages/recruiter/RecruiterAddedJobs";
import UserHome from "./pages/user/UserHome";
import RecruiterHome from "./pages/recruiter/RecruiterHome";
import UserProfile from "./pages/user/UserProfile";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/jobs" element={<Jobs />} />
        <Route
          path="/user/dashboard"
          element={
            <ProtectedRoute allowedRoles={["JOB_SEEKER"]}>
              <UserDashboard />
            </ProtectedRoute>
          }
        >
          <Route path="/user/dashboard/jobs" element={<Jobs></Jobs>} />
          <Route path="/user/dashboard" element={<UserHome></UserHome>} />
          <Route path="/user/dashboard/applied" element={<AppliedJobs></AppliedJobs>}/>
          <Route path="/user/dashboard/profile" element={<UserProfile></UserProfile>} />
        </Route>

        <Route
          path="/recruiter/dashboard"
          element={
            <ProtectedRoute allowedRoles={["RECRUITER"]}>
              <RecruiterDashboard />
            </ProtectedRoute>
          }
        >
          <Route path="/recruiter/dashboard" element={<RecruiterHome></RecruiterHome>} />
          <Route path="/recruiter/dashboard/add-job" element={<AddJob></AddJob>} />
          <Route path="/recruiter/dashboard/added-jobs" element={<RecruiterAddedJobs></RecruiterAddedJobs>} />
          <Route path="/recruiter/dashboard/applications/:jobId" element={<Application></Application>} />  

        </Route>

        <Route
          path="/admin/dashboard"
          element={
            <ProtectedRoute allowedRoles={["ADMIN"]}>
              <AdminDashboard />
            </ProtectedRoute>
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
