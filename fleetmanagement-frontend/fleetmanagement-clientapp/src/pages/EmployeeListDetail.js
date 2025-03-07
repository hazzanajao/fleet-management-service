import {useDispatch, useSelector} from "react-redux";
import React, {useEffect} from "react";
import {Link} from "react-router-dom";
import Loader from "../components/Loader";
import Error from "../components/Error";
import {Col, ListGroup, Row} from "react-bootstrap";
import {employeeDetail} from "../redux/action/employee";

function EmployeeListDetail({ match }){

    const dispatch = useDispatch()
    const {loading, error, employee} = useSelector((state)=> state.employeeDetails)

    useEffect(()=>{
        dispatch(employeeDetail(match.params.id))
    },[dispatch,match])



    return(
        <div>
            <Link className="btn btn-dark my-3" to="/">
                Back
            </Link>
            {loading && <Loader />}
            {error && <Error variant= 'danger'>{error}</Error>}
            <Row>
                <Col md={3}>
                    <ListGroup variant="flush">
                        <ListGroup.Item>
                            <h1>{employee.firstName}</h1>
                        </ListGroup.Item>
                        <ListGroup.Item>Surname:{employee.surname}</ListGroup.Item>
                        <ListGroup.Item>Position:{employee.position}</ListGroup.Item>
                    </ListGroup>
                </Col>

            </Row>
        </div>
    )
}
export default EmployeeListDetail