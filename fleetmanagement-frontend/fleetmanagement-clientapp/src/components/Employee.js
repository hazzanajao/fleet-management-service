import {Card} from "react-bootstrap";
import {Link} from "react-router-dom";
import React from "react";
import {Button} from "@mui/material";

function Employee({employee}){


    return(
        <div>
            <Card className="my-3 p-3 rounded text-lg-center">
                <Card.Body>
                    <Link to ={`/employeeList/${employee._id}`}>
                        <Card.Title as="div">
                            <Button>
                                <h5 >Firstname : {employee.firstName}</h5>
                            </Button>
                            <Card.Text as="h6">Lastname {employee.surname}</Card.Text>
                        </Card.Title>
                    </Link>


                    <Card.Text as="h6">Position: {employee.position}</Card.Text>

                </Card.Body>
            </Card>
        </div>
    )
}
export default Employee;