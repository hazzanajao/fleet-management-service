import React, {useEffect, useState} from "react";
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import NavBar from "./components/NavBar";
import {Container} from "react-bootstrap";
import CarListDetail from "./pages/CarListDetail";
import CompanyList from "./pages/CompanyList";
import EmployeeList from "./pages/EmployeeList";
import CustomerList from "./pages/CustomerList";
import Footer from "./components/Footer";
import CarList from "./pages/CarList";
import Home from "./pages/Home";
import CompanyListDetail from "./pages/CompanyListDetail";
import SignIn from "./auth/SignIn";
import SignUp from "./auth/SignUp";
import SignOut from "./auth/SignOut";

function App() {

    const [isAuthenticated, setIsAuthenticated] = useState(false);

    useEffect(() => {
        if(sessionStorage.getItem('token') !== null){
            setIsAuthenticated(true);
        }
    }, [])




    return (
        <div>
            <BrowserRouter>
                <NavBar  isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated}  />
                        <Routes>
                            <Route exact path='/' element={<Home/>}/>

                            <Route path="/signin" element={<SignIn isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />}/>
                            <Route path="/signup" element={<SignUp isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />} />
                            <Route path="/signout" element={<SignOut isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />} />

                            <Route exact path='/carList' element={<CarList/>}/>
                            <Route exact path='/carList/:id' element={<CarListDetail/>}/>
                            <Route exact path='/companyList' element={<CompanyList/>}/>
                            <Route exact path='/companyList/:id' element={<CompanyListDetail/>}/>
                            <Route exact path='/employeeList' element={<EmployeeList/>}/>
                            <Route exact path='/customerList' element={<CustomerList/>}/>
                            <Route render={() => <h1> Page not found</h1>}></Route>


                        </Routes>
                <Footer/>
            </BrowserRouter>
        </div>

    );
}

export default App;
