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


function NavBar(){
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

                            <Nav.Link as={Link} to= '/companyList'>
                                    <EmojiTransportationIcon/> Company
                            </Nav.Link>
                            <Nav.Link as={Link} to= '/carList'>
                                    <CarRentalIcon/>Car
                            </Nav.Link>
                            <Nav.Link as={Link} to='/employeeList'>
                                    <PeopleIcon/> Employee
                            </Nav.Link>
                            <Nav.Link as={Link} to= '/customerList'>
                                    <ConnectWithoutContactIcon/> Customer
                            </Nav.Link>
                            <Nav.Link as={Link} to= '/admin'>
                                    <AdminPanelSettingsIcon/> Admin
                            </Nav.Link>
                            <Nav.Link as={Link} to= '/user'>
                                    <PersonIcon/> user
                            </Nav.Link>
                            <Nav.Link as={Link} to='/login'>
                                    <LoginIcon/> Login
                            </Nav.Link>
                            <Nav.Link as={Link} to='/logout'>
                                    <LogoutIcon/> Logout
                            </Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </header>
    );
}

export default NavBar;