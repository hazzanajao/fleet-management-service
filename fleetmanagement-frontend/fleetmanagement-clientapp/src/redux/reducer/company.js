import { COMPANY_LIST_REQUEST, COMPANY_LIST_SUCCESS, COMPANY_LIST_FAIL,COMPANY_DETAILS_REQUEST,COMPANY_DETAILS_SUCCESS,COMPANY_DETAILS_FAIL } from "../constant/constants"


export const companyReducer = (state = {companies:[]}, action)=>{
    switch (action.type) {
        case COMPANY_LIST_REQUEST:
            return {
                ...state, loading: true
            }
        case COMPANY_LIST_SUCCESS:
            return{
                ...state,loading:false, companies:action.payload
            }
        case COMPANY_LIST_FAIL:
            return{...state,loading:false, error:action.payload}
        default:
            return state;
    }
}

export const companyDetailsReducer = (state = { company:{reviews:[]}}, action)=>{
    switch (action.type) {
        case COMPANY_DETAILS_REQUEST:
            return {
                ...state,loading: true
            }
        case COMPANY_DETAILS_SUCCESS:
            return{
                ...state,loading:false, company:action.payload
            }
        case COMPANY_DETAILS_FAIL:
            return{...state,loading:false, error:action.payload}
        default:
            return state;
    }
}