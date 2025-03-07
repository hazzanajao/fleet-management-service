import React from "react";
import {Col, Container, Row} from "react-bootstrap";

function Footer(){
    return (
        <footer className='bg-dark text-white text-center py-3 '>
            <Container>
                <Row>
                    <Col >
                        Copyright &copy; FleetManagement Oy
                    </Col>
                </Row>
            </Container>
        </footer>
    )
}
export default Footer;