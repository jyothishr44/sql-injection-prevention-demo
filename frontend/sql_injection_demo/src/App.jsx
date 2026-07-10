import Register from "./pages/Register";
import Login from "./pages/Login";
import "./App.css";

function App() {
  return (
    <>
      <div className="app">
        <h1 className="title">SQL Injection Prevention Demo</h1>

        <div className="container">
          <Register />
          <Login />
        </div>
      </div>
    </>
  );
}

export default App;
