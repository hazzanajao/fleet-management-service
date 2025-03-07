import {useEffect} from "react";
import { Row, Col } from 'react-bootstrap';
import Loader from '../components/Loader';
import Error from '../components/Error';
import { listCars } from '../redux/action/car';
import {useDispatch, useSelector} from 'react-redux'
import Car from "../components/Car";

function CarList(){

    const dispatch = useDispatch()
    const {loading, error, cars} = useSelector((state)=>state.carList)


    useEffect(()=>{
        dispatch(listCars())
    },[dispatch])

    return (
        <>
            <h1 style={{textAlign:"center"}}>Latest Cars</h1>
            {loading && <Loader />}
            {error && <Error variant= 'danger'>{error}</Error>}
            <Row>
                {cars.map((car)=>(
                    <Col sm={12} md={6} lg={4} xl= {3} key ={car._id}>
                        <Car car = {car} />
                    </Col>
                ))}
            </Row>

        </>
    )
}
export default CarList;