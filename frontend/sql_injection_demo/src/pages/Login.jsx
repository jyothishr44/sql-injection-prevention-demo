import { useState } from "react";
import api from "../services/api";

const Login = () => {
  const [user, setUser] = useState({ username: "", password: "" });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    const { value, name } = e.target;
    setUser({ ...user, [name]: value });
  };

  const loginStatement = async () => {
    try {
      const response = await api.post("/login-statement", user);

      setMessage(response.data);
    } catch {
      setMessage("Error");
    }
  };

  const loginPrepared = async () => {
    try {
      const response = await api.post("/login-prepared", user);

      setMessage(response.data);
    } catch {
      setMessage("Error");
    }
  };

  return (
    <div className="card">
      <h2>🔐 Authentication</h2>

      <input
        type="text"
        name="username"
        placeholder="Username"
        value={user.username}
        onChange={handleChange}
      />

      <input
        type="password"
        name="password"
        placeholder="Password"
        value={user.password}
        onChange={handleChange}
      />

      <button className="statement-btn" onClick={loginStatement}>
        Login using Statement
      </button>

      <button className="prepared-btn" onClick={loginPrepared}>
        Login using PreparedStatement
      </button>

      <h3 className="message">{message}</h3>
    </div>
  );
};

export default Login;
