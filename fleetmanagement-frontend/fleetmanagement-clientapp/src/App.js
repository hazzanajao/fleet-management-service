import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import NavBar from "./components/NavBar";
import {Container} from "react-bootstrap";
import CarList from "./pages/CarList";
import Home from "./pages/Home";
import CompanyList from "./pages/CompanyList";
import EmployeeList from "./pages/EmployeeList";
import CustomerList from "./pages/CustomerList";
import Footer from "./components/Footer";

function App() {

  return (
      <Router>
        <NavBar />
        <main className="py-3">
          <Container>
              <Routes>
            <Route path = '/' component = {Home} exact/>
            <Route path = '/company' component = {CompanyList}/>
            <Route path = '/employee' component = {EmployeeList}/>
            <Route path = '/customer' component = {CustomerList}/>
            <Route path = '/car' component = {CarList}/>
              </Routes>
          </Container>
        </main>
        <Footer/>
      </Router>
  );
}

export default App;
