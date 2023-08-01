import React, {useEffect} from "react";
import { Link } from "react-router-dom";
import { Row, Col, ListGroup, Card, Button } from "react-bootstrap";
import Loader from "../components/Loader";
import Error from "../components/Error";
import {useDispatch, useSelector} from "react-redux";
import { companyDetail } from '../redux/action/company';

function CompanyListDetail({ match }){

    const dispatch = useDispatch()
    const {loading, error, company} = useSelector((state)=> state.companyDetails)

    useEffect(()=>{
        dispatch(companyDetail(match.params.id))
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
                            <h1>{company.companyName}</h1>
                        </ListGroup.Item>
                        <ListGroup.Item>Address:{company.address}</ListGroup.Item>
                        <ListGroup.Item>Owner:{company.owner}</ListGroup.Item>
                        <ListGroup.Item>Website:{company.website}</ListGroup.Item>
                        <ListGroup.Item>Email:{company.email}</ListGroup.Item>
                        <ListGroup.Item>Email:{company.phone}</ListGroup.Item>
                    </ListGroup>
                </Col>

            </Row>
        </div>
    )
}
export default CompanyListDetail;