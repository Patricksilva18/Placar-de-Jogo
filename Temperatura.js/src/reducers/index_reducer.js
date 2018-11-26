import { combineReducers } from "redux";
import WeatherReducer from './redurcer_weather';


const rootReducer = combineReducers({
   weather:WeatherReducer
});


export default rootReducer;