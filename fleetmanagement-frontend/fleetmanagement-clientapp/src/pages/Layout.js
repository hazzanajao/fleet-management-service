import toyota1 from "../Assets/Images/toyota1.png"

function Layout(){

    return(
        <wrapper className="top">

            <div className="topLeft">
             <h1> Hire your vehicle of choice</h1>
            </div>

            <div className="topRight">
             <img src={toyota1}
                  className="toyota"
                  alt ="toyota-image"
                  style={styles.toyota}
             />
            </div>

        </wrapper>
    )
}

const styles ={

    top:{
        display: "flex",
        width: "100%",
    },
    topLeft:{
        width: "100%",
        position: "absolute"
    },
    topRight:{
        width: "100%",
        position: "relative"
    },
    toyota:{
        width:"100%",
        height:"50%"
    }

}