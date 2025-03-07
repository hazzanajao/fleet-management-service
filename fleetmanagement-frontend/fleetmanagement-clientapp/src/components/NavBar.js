import React from "react";
import {Container, Nav, Navbar} from "react-bootstrap"
import {Link} from 'react-router-dom';
import EmojiTransportationIcon from '@mui/icons-material/EmojiTransportation';
import CarRentalIcon from '@mui/icons-material/CarRental';
import PeopleIcon from '@mui/icons-material/People';
import ConnectWithoutContactIcon from '@mui/icons-material/ConnectWithoutContact';
import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';
import PersonIcon from '@mui/icons-material/Person';
import LoginIcon from '@mui/icons-material/Login';
import LogoutIcon from '@mui/icons-material/Logout';


function NavBar({isAuthenticated, setIsAuthenticated}){
    return (
        <header>
            <Navbar bg="dark" variant="dark" expand="lg" collapseOnSelect>
                <Container>

                    <Nav.Link as={Link} to='/'>
                        <Navbar.Brand >FleetManagement Oy</Navbar.Brand>
                    </Nav.Link>

                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>

                    <Navbar.Collapse id="basic-navbar-nav">

                        <Nav className= "ms-auto">

                            {isAuthenticated &&  <Nav.Link as={Link} to= '/companyList'>
                                    <EmojiTransportationIcon/> Company
                            </Nav.Link>}

                            {isAuthenticated &&    <Nav.Link as={Link} to= '/carList'>
                                    <CarRentalIcon/>Car
                            </Nav.Link> }

                            { isAuthenticated &&   <Nav.Link as={Link} to='/employeeList'>
                                    <PeopleIcon/> Employee
                            </Nav.Link>}

                            {isAuthenticated &&  <Nav.Link as={Link} to= '/customerList'>
                                    <ConnectWithoutContactIcon/> Customer
                            </Nav.Link>}

                            {isAuthenticated &&  <Nav.Link as={Link} to= '/admin'>
                                    <AdminPanelSettingsIcon/> Admin
                            </Nav.Link>}

                            {isAuthenticated &&  <Nav.Link as={Link} to= '/user'>
                                    <PersonIcon/> user
                            </Nav.Link>}

                            {!isAuthenticated &&  <Nav.Link as={Link} to='/signin'>
                                    <LoginIcon/>  Signin
                            </Nav.Link>}

                            {isAuthenticated &&    <Nav.Link as={Link} to='/signout'>
                                    <LogoutIcon/>Signout
                            </Nav.Link> }

                            {!isAuthenticated &&    <Nav.Link as={Link} to='/signup'>
                                <LogoutIcon/> Signup
                            </Nav.Link> }
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </header>
    );
}

export default NavBar;