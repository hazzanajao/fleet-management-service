import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import Loader from "../components/Loader";
import Error from "../components/Error";
import {Col, Row} from "react-bootstrap";
import {listEmployees} from "../redux/action/employee";
import Employee from "../components/Employee";

function EmployeeList(){
    const dispatch = useDispatch()
    const {loading, error, employees} = useSelector((state)=>state.employeeList)


    useEffect(()=>{
        dispatch(listEmployees())
    },[dispatch])

    return (
        <>
            <h1 style={{textAlign:"center"}}>Employee List</h1>
            {loading && <Loader />}
            {error && <Error variant= 'danger'>{error}</Error>}
            <Row>
                {employees.map((employee)=>(
                    <Col sm={12} md={6} lg={4} xl= {3} key ={employee._id}>
                        <Employee employee= {employee} />
                    </Col>
                ))}
            </Row>

        </>
    )
}
export default EmployeeList;