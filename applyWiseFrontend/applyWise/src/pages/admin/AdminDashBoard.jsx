import Navbar from "../../components/Navbar";
import AdminNav from "./AdminNav";

function AdminDashboard() {
  return (
    <>
      <AdminNav></AdminNav>
      <div className="p-6">
        <h1 className="text-2xl font-bold">Admin Dashboard</h1>

        <p>Manage platform users and jobs.</p>
      </div>
    </>
  );
}

export default AdminDashboard;
