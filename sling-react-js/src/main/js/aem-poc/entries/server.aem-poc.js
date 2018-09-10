import React from 'react'
import ReactDOMServer from 'react-dom/server';
import AemPublishRootComponent from './../components/aem-publish-component'

const render = (conf) => {
    // console.log(conf);
    return ReactDOMServer.renderToString(<AemPublishRootComponent config={conf}/>);
};

(global).renderReactElement = render;
renderReactElement = render;
module.exports = render;