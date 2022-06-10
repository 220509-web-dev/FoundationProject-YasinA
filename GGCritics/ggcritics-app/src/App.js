import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Login } from "./Login";
import { Signup } from "./Signup";
import { Home } from "./Home";
import { ContextProvider } from "./Context/GlobalContext";
import { Navigation } from "./Navigation";

function App() {
  return (
    <div className="App">
      <ContextProvider>
        <BrowserRouter>
          <Navigation />
          <Routes>
            <Route exact path="/" element={<Home />} />
            <Route exact path="/login" element={<Login />} />
            <Route exact path="/signup" element={<Signup />} />
          </Routes>
        </BrowserRouter>
      </ContextProvider>
    </div>
  );
}

export default App;
