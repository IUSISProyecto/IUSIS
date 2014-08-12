isis-wicket-gmap3
=================

[![Build Status](https://travis-ci.org/danhaywood/isis-wicket-gmap3.png?branch=master)](https://travis-ci.org/danhaywood/isis-wicket-gmap3)

An extension for [Apache Isis](http://isis.apache.org)' [Wicket viewer](http://isis.apache.org/components/viewers/wicket/about.html), to render a collection of entities within a map (using google's [gmap3](https://developers.google.com/maps/documentation/javascript/) API).  

## Screenshots

The following screenshots are taken from the `zzzdemo` app (adapted from Isis' quickstart archetype).  Each `ToDoItem` has been made `Locatable`.  See below for further details.

![](https://raw.github.com/danhaywood/isis-wicket-gmap3/master/images/screenshot-1.png)

![](https://raw.github.com/danhaywood/isis-wicket-gmap3/master/images/screenshot-2.png)


## API & Usage

### Rendering objects on a map

Make your entity implement `com.danhaywood.isis.wicket.gmap3.applib.Locatable`, so that it provides a `Location` property of type `com.danhaywood.isis.wicket.gmap3.applib.Location`.

If using the JDO objectstore, then this property will need to be annotated as `@Persistent`.  Other objectstores (at least, those that use the facilities of Isis' `ValueSemanticsProvider` API) should require no additional configuration.

For example:

    import com.danhaywood.isis.wicket.gmap3.applib.Locatable;
    import com.danhaywood.isis.wicket.gmap3.applib.Location;

    public class ToDoItem implements Locatable {

        ...

        // {{
        @Persistent
        private Location location;
        
        @MemberOrder(name="Detail", sequence = "10")
        @Optional
        public Location getLocation() {
            return location;
        }
        public void setLocation(Location location) {
            this.location = location;
        }
        // }}

    }

You should then find that any collections of entities that have `Locatable` properties (either returned from an action, or as a parented collection) will be rendered in a map.

### End-user entry of `Location`s

If you have configured the `LocationLookupService` (recommended), then you can write an action to lookup the `Location` using the service injected into some entity.  For example:

    public void lookupLocation(@Named("Description") String description) {
        setLocation(locationLookupService.lookup(description));
    }

Alternatively, you can allow the `Location` to be specified as a string.  The format is:

     mmm.mmm;nnn.nnn

where:

* `mmm.mmm` is the latitute, and
* `nnn.nnn` is the longitude 


## Maven Configuration

In your project's parent `pom.xml`, add to the `<dependencyManagement>` section:

    <dependencyManagement>
        <dependencies>
            ...
            <dependency>
                <groupId>com.danhaywood.isis.wicket</groupId>
                <artifactId>danhaywood-isis-wicket-gmap3</artifactId>
                <version>x.y.z</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            ...
        </dependencies>
    </dependencyManagement>

where `x.y.z` is the latest available version (search the [Maven Central Repo](http://search.maven.org/#search|ga|1|isis-wicket-gmap3)).

In your project's DOM `pom.xml`, add a dependency on the `applib` module:

    <dependencies>
        ...
        <dependency>
            <groupId>com.danhaywood.isis.wicket</groupId>
            <artifactId>danhaywood-isis-wicket-gmap3-applib</artifactId>
        </dependency>
        ...
    </dependencies> 

Although not mandatory, you might also want to use the `LocationLookupService` that's provided, allowing for simple descriptions (eg "10 Downing Street, London") to be converted into `Location`s.  Add this dependency in your project's DOM `pom.xml`:

    <dependencies>
        ...
        <dependency>
            <groupId>com.danhaywood.isis.wicket</groupId>
            <artifactId>danhaywood-isis-wicket-gmap3-service</artifactId>
        </dependency>
        ...
    </dependencies> 


Finally, there is a required dependency in your project's webapp `pom.xml` to the `ui` module:

    <dependencies>
        ...
        <dependency>
            <groupId>com.danhaywood.isis.wicket</groupId>
            <artifactId>danhaywood-isis-wicket-gmap3-ui</artifactId>
        </dependency>
        ...
    </dependencies> 



## Registering the LocationLookupService

In the `WEB-INF\isis.properties` file, add:

    isis.services = ...,\
                    com.danhaywood.isis.wicket.gmap3.service.LocationLookupService,\
                    ...

## Legal Stuff

### License

    Copyright 2013~2014 Dan Haywood

    Licensed under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

### Dependencies

This module depends upon the following:

    <dependencies>

        <dependency>
            <!-- ASL v2.0 -->
            <groupId>org.apache.isis.core</groupId>
            <artifactId>isis-core-applib</artifactId>
            <version>${isis.version}</version>
        </dependency>

        <dependency>
            <!-- ASL v2.0 -->
            <groupId>org.apache.isis.viewer</groupId>
            <artifactId>isis-viewer-wicket-ui</artifactId>
            <version>${isis-viewer-wicket.version}</version>
        </dependency>

        <dependency>
            <!-- ASL v2.0 -->
            <groupId>org.apache.wicket</groupId>
            <artifactId>wicket</artifactId>
            <type>pom</type>
            <scope>import</scope>
            <version>${wicket.version}</version>
        </dependency>

        <dependency>
            <!-- ASL v2.0 -->
            <groupId>org.wicketstuff</groupId>
            <artifactId>wicketstuff-gmap3</artifactId>
            <version>${wicketstuff-gmap3.version}</version>
        </dependency>

    </dependencies>
