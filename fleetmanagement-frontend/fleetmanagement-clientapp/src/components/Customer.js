import {Card} from "react-bootstrap";
import {Link} from "react-router-dom";
import React from "react";

function Customer({customer}){

    return(
        <div>
            <Card className="my-3 p-3 rounded">
                <Card.Body>
                    <Link to ={`/companyList/${customer._id}`}>
                        <Card.Title as="div">
                            <strong>{customer.companyName}</strong>
                        </Card.Title>
                    </Link>
                    <Card.Text as="h5">Address: {customer.address}</Card.Text>
                    <Card.Text as="h6">Owner: {customer.owner}</Card.Text>
                    <Card.Text as="p">Website: {customer.website}</Card.Text>
                    <Card.Text as="p">Email: {customer.email}</Card.Text>
                    <Card.Text as="p">Phone: {customer.phone}</Card.Text>
                </Card.Body>
            </Card>
        </div>
    )
}
export default Customer;