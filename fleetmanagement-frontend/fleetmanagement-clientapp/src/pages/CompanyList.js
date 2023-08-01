import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import Loader from "../components/Loader";
import Error from "../components/Error";
import {Col, Row} from "react-bootstrap";
import Company from "../components/Company";
import {listCompanies} from "../redux/action/company";

function CompanyList(){
    const dispatch = useDispatch()
    const {loading, error, companies} = useSelector((state)=>state.companyList)


    useEffect(()=>{
        dispatch(listCompanies())
    },[dispatch])

    return (
        <>
            <h1>Company List</h1>
            {loading && <Loader />}
            {error && <Error variant= 'danger'>{error}</Error>}
            <Row>
                {companies.map((company)=>(
                    <Col sm={12} md={6} lg={4} xl= {3} key ={company._id}>
                        <Company company= {company} />
                    </Col>
                ))}
            </Row>

        </>
    )
}
export default CompanyList;