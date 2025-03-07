import {createStore, combineReducers, applyMiddleware} from 'redux'
import thunk from 'redux-thunk'
import {composeWithDevTools} from 'redux-devtools-extension'
import {carDetailsReducer, carReducer } from './reducer/car'
import {companyDetailsReducer, companyReducer} from "./reducer/company";
import {employeeDetailsReducer, employeeReducer,} from './reducer/employee'

const reducers = combineReducers({
    carList:carReducer,
    carDetails: carDetailsReducer,
    companyList:companyReducer,
    companyDetails:companyDetailsReducer,
    employeeList:employeeReducer,
    employeeDetails:employeeDetailsReducer

})
const initialState = {}
const middleware = [thunk]
const store = createStore(reducers, initialState,composeWithDevTools(applyMiddleware(...middleware)))

export default store
