import React from "react";
import { Link } from "react-router-dom";
import { Card } from "react-bootstrap";


function Car({car}){

    return(
        <Card className="my-3 p-3 rounded">
            <Link to ={`/car/${car._id}`}>
                <Card.Img src={car.imageUrl} variant="top" />
            </Link>

            <Card.Body>
                <Link to ={`/car/${car._id}`}>
                    <Card.Title as="div">
                        <strong>{car.name}</strong>
                    </Card.Title>
                </Link>
                <Card.Text as="h3">€{car.year}</Card.Text>
                <Card.Text as="h3">€{car.perDayRent}</Card.Text>
            </Card.Body>
        </Card>
    )

}
export default Car;