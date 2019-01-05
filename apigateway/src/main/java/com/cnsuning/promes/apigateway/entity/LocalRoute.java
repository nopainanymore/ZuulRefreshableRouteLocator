package com.cnsuning.promes.apigateway.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * apigateway: LocalRoute
 *
 * @author 李旺 (Employee ID: 18070881)
 * @version 1.0.0, 2019-01-05 09:36
 * @since 1.0.0, 2019-01-05 09:36
 */
@Data
@Entity
public class LocalRoute {

    @javax.persistence.Id
    @GeneratedValue
    private Long localRouteId;

    private String id;

    private String path;

    private String serviceId;

    private String url;

    private boolean stripPrefix = true;

    private Boolean retryable;

    private Boolean enabled;

    public LocalRoute() {
    }

    public Long getLocalRouteId() {
        return localRouteId;
    }

    public void setLocalRouteId(Long localRouteId) {
        this.localRouteId = localRouteId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isStripPrefix() {
        return stripPrefix;
    }

    public void setStripPrefix(boolean stripPrefix) {
        this.stripPrefix = stripPrefix;
    }

    public Boolean getRetryable() {
        return retryable;
    }

    public void setRetryable(Boolean retryable) {
        this.retryable = retryable;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
