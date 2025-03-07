import { EMPLOYEE_LIST_REQUEST, EMPLOYEE_LIST_SUCCESS, EMPLOYEE_LIST_FAIL,EMPLOYEE_DETAILS_REQUEST,EMPLOYEE_DETAILS_SUCCESS,EMPLOYEE_DETAILS_FAIL } from "../constant/constants"


export const employeeReducer = (state = {employees:[]}, action)=>{
    switch (action.type) {
        case EMPLOYEE_LIST_REQUEST:
            return {
                ...state, loading: true
            }
        case EMPLOYEE_LIST_SUCCESS:
            return{
                ...state,loading:false, employees:action.payload
            }
        case EMPLOYEE_LIST_FAIL:
            return{...state,loading:false, error:action.payload}
        default:
            return state;
    }
}

export const employeeDetailsReducer = (state = { employee:{reviews:[]}}, action)=>{
    switch (action.type) {
        case EMPLOYEE_DETAILS_REQUEST:
            return {
                ...state,loading: true
            }
        case EMPLOYEE_DETAILS_SUCCESS:
            return{
                ...state,loading:false, employee:action.payload
            }
        case EMPLOYEE_DETAILS_FAIL:
            return{
                ...state,loading:false, error:action.payload}
        default:
            return state;
    }
}