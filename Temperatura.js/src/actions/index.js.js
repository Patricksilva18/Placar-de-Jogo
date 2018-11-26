import axios from 'axios';

const API_KEY = '6a78596d062dff5944c4e5567';
const ROOT_URL = 'http://api.openweathermap.org/data/2.5/weather?appid=${API_KEY}';

export const FEATCH_WEATHER = 'FEATCH_WEATHER';

export function fetchWeather(city) {
   const url = '${ROOT_URL}&q=${city}, us';
   const request = axios.get(url);
      console.log("Request", (request));
      
   return{
      type: FEATCH_WEATHER,
      payload: request
   };
}