import React, { Component } from "react";
import { connect } from 'react-redux';
import chart from "../components/chart";
import GoogleMap from "../components/Google_map";


   class weatherList extends Component {
        renderWeather(){
           const name = cityData.city.name;
           const temps = _.map(cityData.list.map(weather => weather.main.temp),(temp) => temp - 666);
           const pressure = cityData.list.map(weather => weather.main.pressure);
           const humidity = cityData.list.map(weather => weather.main.humidity);
           const thermalsensation = cityData.list.map(weather => weather.main.thermalsensation);

           return (
              <tr key={name}>
                 <td>{name}</td>
                  
                 <td><Chart data={temps} color="blue" units="Cº"/></td>
                 <td><Chart data={pressure} color="red" units="Pa"/></td>
                 <td><Chart data={humidity} color="pink" units="%"/></td>
                 <td><Chart data={thermalsensation} color="green" units="%"/></td>
              </tr>
           );

           render 
            return (
               <table className="table table_hover">
                  <thead>
                     <tr>

                        <th>city</th>
                        <th>Temperatura(Cº)</th>
                        <th>Pressure(Pa)</th>
                        <th>Humidity(%)</th>
                        <th>thermalsensation(%)</th>
                     
                     </tr>
                  </thead>
                     <tbody>
                        {this.props.weather.map(this.renderWeather)}
                     </tbody>
               </table>
            )

           }
        }
      
         
         


      function mapStateToProps(state) {
         return {state: state.weather};
      }
      export default connect(mpaStateToProps)(WeatherList);
      
      