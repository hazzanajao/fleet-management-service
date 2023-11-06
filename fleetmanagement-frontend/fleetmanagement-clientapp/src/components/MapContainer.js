import { Map, GoogleApiWrapper } from 'google-maps-react';


function MapContainer(){

    const styleMap = {
        width: '100%',
        height: '100%'
    };

    return(

        <div>
            <Map

                zoom={14}
                style={
                    styleMap
                }
                initialCenter={
                    {
                        lat: -1.2884,
                        lng: 36.8233
                    }
                }
            />
        </div>
    )
}

export default MapContainer;