import toyota1 from "../Assets/Images/toyota1.png";
import volkswagen1 from "../Assets/Images/volkswagen1.png"
import Lorry from "../Assets/Images/Lorry.jpg"
import CargoTrailer from "../Assets/Images/CargoTrailer.jpg"
import ServiceArea from "../Assets/Images/ServiceArea.PNG"
import {Slide} from "react-slideshow-image";
import 'react-slideshow-image/dist/styles.css';
import {Button, Card, CardActionArea, CardActions, CardContent, CardMedia, Chip, Typography} from "@mui/material";
import BuildCircleIcon from '@mui/icons-material/BuildCircle';
import CarRepairIcon from '@mui/icons-material/CarRepair';
import CarCrashIcon from '@mui/icons-material/CarCrash';
import PlaceIcon from '@mui/icons-material/Place';
import EuroIcon from '@mui/icons-material/Euro';
import LiveHelpIcon from '@mui/icons-material/LiveHelp';
import MapContainer from "../components/MapContainer";

function HomeList() {

    return (
        <div className="top" style={{display: "inline-block", width: "100%",}}>

            <div className="topRight" style={{
                width: "100%",
            }}>
                <div className="home-image">
                    <img src={toyota1}
                         className="toyota"
                         alt="toyota-image"
                         style={{width: "100%",  position: "absolute", }}
                    />
                    <div className="home-text  "
                         style={{position: "relative",paddingTop:"14%",color:"black", textAlign: "center", fontWeight: "900", fontSize: "3rem"}}>
                       <em className="bg-light p-2"> Fleet Management Application</em>
                    </div>
                </div>



                <div  style={styles.containerMid}>
                    <wrapper className="leftWrapper" style={styles.leftWrapper}>
                        <div className="container" style={styles.container}>
                            <Button style={{backgroundColor: "#0C356A", color: "white"}}>
                                <BuildCircleIcon/>
                                Repair
                            </Button>
                            <Button style={{backgroundColor: "#0C356A", color: "white"}}>
                                <CarRepairIcon/>
                                Maintain
                            </Button>
                            <Button style={{backgroundColor: "#0C356A", color: "white"}}>
                                <CarCrashIcon/>
                                Diagnose
                            </Button>
                        </div>

                    </wrapper>

                    <wrapper className="rightWrapper" style={styles.rightWrapper}>
                        <div className="" style={styles.container}>
                            <Button className="buttonRegion" style={styles.buttonRegion}>
                                <PlaceIcon/>
                                Regions
                            </Button>
                            <Button className="buttonRegion" style={{backgroundColor: "#0C356A", color: "white"}}>
                                <EuroIcon/>
                                Prices
                            </Button>
                            <Button className="buttonRegion" style={{backgroundColor: "#0C356A", color: "white"}}>
                                <LiveHelpIcon/>
                                FAQs
                            </Button>
                        </div>
                    </wrapper>
                </div>

            </div>


            <div style={{ backgroundColor: "lightgray",}}>
<br/><br/>
                <h1 style={{textAlign: "center", fontWeight:"3rem", fontSize:"700"}}> Hire your vehicle of choice</h1>

                <br/>
                <p style={{backgroundColor: "inherit", padding: "10px", textAlign: "center", color: "black"}}> Our
                    service is flexible and tailored
                    towards customers need.
                </p>
                <br/>
                <br/>
                <br/>

                <div className="carContainer" style={{
                    justifyContent: "space-between",
                    display: "flex",
                    padding: "25px",
                    width: "100%",
                    backgroundColor:"lightgray"
                }}>

                    <Card sx={{maxWidth: 400, padding: "15px", borderTop: "2px solid #0C356A"}}>
                        <CardActionArea>
                            <CardMedia
                                component="img"
                                height="250"
                                src={volkswagen1}
                                className="volkswagen"
                                alt="volkswagen-image"
                                style={styles.volkswagen}

                                alt="green iguana"
                            />
                            <CardContent
                                sx={{backgroundColor: "inherit", padding: "8px", textAlign: "center", color: "white"}}>
                                <Typography gutterBottom variant="h5" component="div">
                                    Volkswagen
                                </Typography>
                                <Typography variant="body2" color="black">
                                    Our cars are premium cars built for customer's satisfaction
                                </Typography>
                            </CardContent>
                        </CardActionArea>
                        <CardActions>
                            <Chip label="View More" component="a" href="carList" View
                                  sx={{backgroundColor: "#0C356A", padding: "2px", color: "white"}}/>
                        </CardActions>
                    </Card>

                    <Card sx={{maxWidth: 400, padding: "15px", borderTop: "2px solid #0C356A"}}>
                        <CardActionArea>
                            <CardMedia
                                component="img"
                                height="250"
                                src={toyota1}
                                className="volkswagen"
                                alt="volkswagen-image"
                                style={styles.volkswagen}

                                alt="green iguana"
                            />
                            <CardContent
                                sx={{backgroundColor: "inherit", padding: "8px", textAlign: "center", color: "white"}}>
                                <Typography gutterBottom variant="h5" component="div">
                                    Volkswagen
                                </Typography>
                                <Typography variant="body2" color="black">
                                    Our cars are premium cars built for customer's satisfaction
                                </Typography>
                            </CardContent>
                        </CardActionArea>
                        <CardActions>
                            <CardActions>
                                <Chip label="View More" component="a" href="carList" View
                                      sx={{backgroundColor: "#0C356A", padding: "2px", color: "white"}}/>
                            </CardActions>
                        </CardActions>
                    </Card>
                    <Card sx={{maxWidth: 400, padding: "15px", borderTop: "2px solid #0C356A"}}>
                        <CardActionArea>
                            <CardMedia
                                component="img"
                                height="250"
                                src={volkswagen1}
                                className="volkswagen"
                                alt="volkswagen-image"
                                style={styles.volkswagen}

                                alt="green iguana"
                            />
                            <CardContent
                                sx={{backgroundColor: "inherit", padding: "8px", textAlign: "center", color: "white"}}>
                                <Typography gutterBottom variant="h5" component="div">
                                    Volkswagen
                                </Typography>
                                <Typography variant="body2" color="black">
                                    Our cars are premium cars built for customer's satisfaction
                                </Typography>
                            </CardContent>
                        </CardActionArea>
                        <CardActions>
                            <Chip label="View More" component="a" href="carList" View
                                  sx={{backgroundColor: "#0C356A", padding: "2px", color: "white"}}/>
                        </CardActions>
                    </Card>

                    <Card sx={{maxWidth: 400, padding: "15px", borderTop: "2px solid #0C356A"}}>

                        <CardActionArea>
                            <CardMedia
                                component="img"
                                height="250"
                                src={toyota1}
                                className="volkswagen"
                                alt="volkswagen-image"
                                style={styles.volkswagen}

                                alt="green iguana"
                            />
                            <CardContent
                                sx={{backgroundColor: "inherit", padding: "8px", textAlign: "center", color: "white"}}>
                                <Typography gutterBottom variant="h5" component="div">
                                    Volkswagen
                                </Typography>
                                <Typography variant="body2" color="black">
                                    Our cars are premium cars built for customer's satisfaction
                                </Typography>
                            </CardContent>
                        </CardActionArea>

                        <CardActions >
                            <CardActions>
                                <Chip label="View More" component="a" href="carList" View
                                      sx={{backgroundColor: "#0C356A", padding: "2px", color: "white"}}/>
                            </CardActions>
                        </CardActions>

                    </Card>

                </div>
            </div>
        </div>

    )
}

export default HomeList;

const styles = {
    top: {
        display: "block",
        width: "100%",
    },
    container: {
        justifyContent: "space-around",
        display: "flex",
        padding: "10px",
        width: "100%",
    },
    containerMid: {
        display: "flex",
        padding: "10px",
        width: "100%",
        backgroundColor: "black",
        marginTop:"30%"
    },
    leftWrapper: {
        display: "flex",
        float: "start",
        width: "100%",
    },
    rightWrapper: {
        display: "flex",
        justifyContent: "space-around",
        width: "100%",
    },

    topLeft: {
        width: "50%",
    },

    volkswagen: {
        width: "100%",
    },
    cargo: {
        width: "100%",
    },
    mapArea: {
        width: "100%"
    },
    buttonRegion: {
        backgroundColor: "#0C356A",
        color: "white",
        justifyContent: "right",
        width: "fit-content"
    }
}