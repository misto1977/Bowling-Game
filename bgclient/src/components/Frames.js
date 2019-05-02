import React, { Component } from 'react';
// components
import Frame from "./Frame";

class Frames extends Component {

    render() {

      const frames = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

      return (
        <div className="frames">
          {frames.map( (frame) =>
            <Frame key={frame}
              id={frame}
              attempt={this.props.attempt}
              active={this.props.active}
              knocked={this.props.knocked}
              frameRes={this.props.frameRes}
            />
          )}
        </div>
      )
    }

}

export default Frames;
