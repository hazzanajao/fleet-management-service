import React from 'react'
import {Alert} from 'react-bootstrap'

function Error({variant, children}){
    return (
        <Alert variant = {variant}>
            {children}
        </Alert>
    )
}

Error.defaultProps = {
    variant:'info'
}

export default Error
