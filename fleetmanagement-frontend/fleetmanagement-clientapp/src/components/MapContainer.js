import React, { Component } from 'react';
import { Map, GoogleApiWrapper } from 'google-maps-react';




export class MapContainer extends Component {


    render() {
        return (

            <div>
                <Map
                    google={this.props.google}
                    zoom={14}
                    style={
                        styleMap
                    }
                    initialCenter={
                        {
                            lat: 60.192059,
                            lng: 24.945831
                        }
                    }
                />
            </div>
        )
    }
}


export default GoogleApiWrapper(
    (props) => ({
            apiKey: props.apiKey
        }
    ))(MapContainer)

const styleMap = {
    width: '50%',
    height: '50%'
};