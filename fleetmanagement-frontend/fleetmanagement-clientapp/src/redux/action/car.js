import{
    CAR_LIST_REQUEST,
    CAR_LIST_SUCCESS,
    CAR_LIST_FAIL,

    CAR_DETAILS_REQUEST,
    CAR_DETAILS_SUCCESS,
    CAR_DETAILS_FAIL
} from '../constant/constants';

import axios from 'axios'

export const listCars = ()=> async(dispatch)=>{

    try {
        dispatch({
            type:CAR_LIST_REQUEST
        })

        const {data} = await axios.get('http://localhost:8080/api/v1/cars')

        dispatch({
            type: CAR_LIST_SUCCESS,
            payload: data
        })


    } catch (error) {
        dispatch({
            type:CAR_LIST_FAIL,
            payload: error.response && error.response.data.message
                ? error.response.data.message
                : error.message
        })

    }

}

export const carDetail = (id)=> async(dispatch)=>{
    try {
        dispatch({
            type:CAR_DETAILS_REQUEST
        })

        const {data} = await axios.get(`http://localhost:8080/api/v1/cars/${id}`)

        dispatch({
            type: CAR_DETAILS_SUCCESS,
            payload: data
        })


    } catch (error) {
        dispatch({
            type:CAR_DETAILS_FAIL,
            payload: error.response && error.response.data.message
                ? error.response.data.message
                : error.message
        })

    }

}
