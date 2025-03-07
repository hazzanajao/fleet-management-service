import {EMPLOYEE_LIST_REQUEST, EMPLOYEE_LIST_SUCCESS,EMPLOYEE_LIST_FAIL,EMPLOYEE_DETAILS_REQUEST,EMPLOYEE_DETAILS_SUCCESS,EMPLOYEE_DETAILS_FAIL } from '../constant/constants';
import axios from 'axios'

export const listEmployees = ()=> async(dispatch)=>{
    try {
        dispatch({
            type:EMPLOYEE_LIST_REQUEST
        })

        const {data} = await axios.get(' http://localhost:8080/api/v1/employees')

        dispatch({
            type: EMPLOYEE_LIST_SUCCESS,
            payload: data
        })

    } catch (error) {
        dispatch({
            type:EMPLOYEE_LIST_FAIL,
            payload: error.response && error.response.data.message
                ? error.response.data.message
                : error.message
        })
    }

}

export const employeeDetail = (id)=> async(dispatch)=>{

    try {
        dispatch({
            type:EMPLOYEE_DETAILS_REQUEST
        })

        const {data} = await axios.get(` http://localhost:8080/api/v1/employees/${id}`)

        dispatch({
            type: EMPLOYEE_DETAILS_SUCCESS,
            payload: data
        })


    } catch (error) {
        dispatch({
            type:EMPLOYEE_DETAILS_FAIL,
            payload: error.response && error.response.data.message
                ? error.response.data.message
                : error.message
        })

    }

}
