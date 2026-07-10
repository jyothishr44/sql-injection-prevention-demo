import { useState } from "react";
import api from "../services/api";

const Register = () => {
  const [user, setUser] = useState({ username: "", password: "" });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;

    setUser({ ...user, [name]: value });
  };

  const register = async () => {
    try {
      const response = await api.post("/register", user);

      setMessage(response.data);

      setUser({ username: "", password: "" });
    } catch (err) {
      setMessage("Registration Failed");
    }
  };

  return (
    <div className="card">
      <h2>👤 User Registration</h2>

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

      <button className="register-btn" onClick={register}>
        Register
      </button>

      <p className="message">{message}</p>
    </div>
  );
};

export default Register;
