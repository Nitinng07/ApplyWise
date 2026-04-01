import React from "react";
import {
  BrowserRouter,
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Index from "./pages/Home";
import Login from "./pages/Login";
import Home from "./pages/Home";

const Routing = () => {
  let routes = createBrowserRouter([
    {
      path: "/",
      element: <Home></Home>,
    },
    {
        path:'/login',
        element : <Login></Login>
    }
  ]);
  return (
    <div>
      <RouterProvider router={routes}></RouterProvider>
    </div>
  );
};

export default Routing;
