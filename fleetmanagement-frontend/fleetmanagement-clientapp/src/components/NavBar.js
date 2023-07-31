import {Container, Nav, Navbar} from "react-bootstrap"
import {LinkContainer} from "react-router-bootstrap"

function NavBar(){
    return (
        <header>
            <Navbar bg="dark" variant="dark" expand="lg" collapseOnSelect>
                <Container>

                    <LinkContainer to ='/'>
                        <Navbar.Brand >FleetManagement Oy</Navbar.Brand>
                    </LinkContainer>

                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>

                    <Navbar.Collapse id="basic-navbar-nav">

                        <Nav className= "ms-auto">
                            <LinkContainer to= '/company'>
                                <Nav.Link>
                                    <i className= 'fas fa-shopping-cart'></i>Company
                                </Nav.Link>
                            </LinkContainer>
                            <LinkContainer to= '/car'>
                                <Nav.Link>
                                    <i className= 'fas fa-shopping-cart'></i>Car
                                </Nav.Link>
                            </LinkContainer>
                            <LinkContainer to= '/employee'>
                                <Nav.Link>
                                    <i className= 'fas fa-shopping-cart'></i>Employee
                                </Nav.Link>
                            </LinkContainer>
                            <LinkContainer to= '/customer'>
                                <Nav.Link>
                                    <i className= 'fas fa-shopping-cart'></i>Customer
                                </Nav.Link>
                            </LinkContainer>
                            <LinkContainer to= '/cart'>
                                <Nav.Link>
                                    <i className= 'fas fa-shopping-cart'></i>Cart
                                </Nav.Link>
                            </LinkContainer>

                            <LinkContainer to ='/login'>
                                <Nav.Link>
                                    <i className= 'fas fa-user'></i>Login
                                </Nav.Link>
                            </LinkContainer>
                            <LinkContainer to ='/login'>
                                <Nav.Link>
                                    <i className= 'fas fa-user'></i>Logout
                                </Nav.Link>
                            </LinkContainer>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </header>
    );
}

export default NavBar;