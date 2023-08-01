import { CAR_LIST_REQUEST, CAR_LIST_SUCCESS, CAR_LIST_FAIL,CAR_DETAILS_REQUEST,CAR_DETAILS_SUCCESS,CAR_DETAILS_FAIL } from "../constant/constants"


export const carReducer = (state = {cars:[]}, action)=>{
    switch (action.type) {
        case CAR_LIST_REQUEST:
            return {
                ...state, loading: true
            }
        case CAR_LIST_SUCCESS:
            return{
                ...state,loading:false, cars:action.payload
            }
        case CAR_LIST_FAIL:
            return{...state,loading:false, error:action.payload}


        default:
            return state;
    }
}

export const carDetailsReducer = (state = { car:{reviews:[]}}, action)=>{
    switch (action.type) {
        case CAR_DETAILS_REQUEST:
            return {
                ...state,loading: true
            }
        case CAR_DETAILS_SUCCESS:
            return{
                ...state,loading:false, car:action.payload
            }
        case CAR_DETAILS_FAIL:
            return{...state,loading:false, error:action.payload}


        default:
            return state;
    }
}