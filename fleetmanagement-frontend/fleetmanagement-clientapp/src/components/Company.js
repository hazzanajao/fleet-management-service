import React from "react";
import { Link } from "react-router-dom";
import { Card } from "react-bootstrap";


function Company({company}){

    return(
        <Card className="my-3 p-3 rounded">
            <Card.Body>
                <Link to ={`/companyList/${company._id}`}>
                    <Card.Title as="div">
                        <strong>{company.companyName}</strong>
                    </Card.Title>
                </Link>
                <Card.Text as="h5">Address: {company.address}</Card.Text>
                <Card.Text as="h6">Owner: {company.owner}</Card.Text>
                <Card.Text as="p">Website: {company.website}</Card.Text>
                <Card.Text as="p">Email: {company.email}</Card.Text>
                <Card.Text as="p">Phone: {company.phone}</Card.Text>
            </Card.Body>
        </Card>
    )

}
export default Company;