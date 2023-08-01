import {useEffect} from "react";
import { Link } from "react-router-dom";
import { Row, Col, Image, ListGroup, Card, Button } from "react-bootstrap";
import Loader from "../components/Loader";
import Error from "../components/Error";
import {useDispatch, useSelector} from "react-redux";
import { carDetail } from '../redux/action/car';

function CarListDetail({ match }){

    const dispatch = useDispatch()
    const {loading,car, error} = useSelector((state)=> state.carDetails)

    useEffect(()=>{
        dispatch(carDetail(match.params.id))
    },[dispatch,match])



    return(
        <div>
            <Link className="btn btn-dark my-3" to="/">
                Back
            </Link>
            {loading && <Loader />}
            {error && <Error variant= 'danger'>{error}</Error>}
            <Row>
                <Col md={6}>
                    <Image src={car.imageUrl} alt={car.name} fluid />
                </Col>

                <Col md={3}>
                    <ListGroup variant="flush">
                        <ListGroup.Item>
                            <h3>{car.name}</h3>
                        </ListGroup.Item>
                        <ListGroup.Item>Year:{car.year}</ListGroup.Item>
                        <ListGroup.Item>Price:{car.perDayRent}€</ListGroup.Item>
                    </ListGroup>
                </Col>

            </Row>
        </div>
    )
}
export default CarListDetail;