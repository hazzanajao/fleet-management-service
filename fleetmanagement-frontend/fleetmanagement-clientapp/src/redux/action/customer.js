import {
    CUSTOMER_LIST_REQUEST,
    CUSTOMER_LIST_SUCCESS,
    CUSTOMER_LIST_FAIL,
    CUSTOMER_DETAILS_REQUEST,
    CUSTOMER_DETAILS_SUCCESS,
    CUSTOMER_DETAILS_FAIL } from '../constant/constants';
import axios from 'axios'

export const listCustomers = ()=> async(dispatch)=>{
    try {
        dispatch({
            type:CUSTOMER_LIST_REQUEST
        })

        const {data} = await axios.get('')

        dispatch({
            type: CUSTOMER_LIST_SUCCESS,
            payload: data
        })


    } catch (error) {
        dispatch({
            type:CUSTOMER_LIST_FAIL,
            payload: error.response && error.response.data.message
                ? error.response.data.message
                : error.message
        })

    }

}

export const customerDetail = (id)=> async(dispatch)=>{
    try {
        dispatch({
            type:CUSTOMER_DETAILS_REQUEST
        })

        const {data} = await axios.get(` `)

        dispatch({
            type: CUSTOMER_DETAILS_SUCCESS,
            payload: data
        })


    } catch (error) {
        dispatch({
            type:CUSTOMER_DETAILS_FAIL,
            payload: error.response && error.response.data.message
                ? error.response.data.message
                : error.message
        })

    }

}
