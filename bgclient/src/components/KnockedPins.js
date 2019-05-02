import React, { Component } from 'react';

//Class component
class KnockedPins extends Component {

    constructor(props) {
      super(props);
      this.state = {knockedPins : props.knockedPins}
    }
  
    render() {
      return (
        <button onClick={() => this.props.onClick(this.state.knockedPins)}>
          {this.state.knockedPins}
        </button>
      );
    }
  
  } 

  export default KnockedPins;